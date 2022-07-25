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
public final class c84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    @SuppressLint({"LambdaLast"})
    public static Bundle a(@NonNull z74 z74Var, @Nullable Bundle bundle, String... strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, z74Var, bundle, strArr)) == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getLong("timestamp", -1L) < 0) {
                bundle.putLong("timestamp", System.currentTimeMillis());
            }
            return z74Var.m(bundle, new HashSet(Arrays.asList(strArr)));
        }
        return (Bundle) invokeLLL.objValue;
    }

    @NonNull
    @SuppressLint({"LambdaLast"})
    public static Bundle b(@NonNull z74 z74Var, @NonNull String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, z74Var, strArr)) == null) ? a(z74Var, null, strArr) : (Bundle) invokeLL.objValue;
    }
}
