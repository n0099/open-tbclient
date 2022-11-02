package com.google.android.gms.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
/* loaded from: classes7.dex */
public class SharedPreferencesUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SharedPreferencesUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static void publishWorldReadableSharedPreferences(@NonNull Context context, @NonNull SharedPreferences.Editor editor, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, editor, str) == null) {
            throw new IllegalStateException("world-readable shared preferences should only be used by apk");
        }
    }
}
