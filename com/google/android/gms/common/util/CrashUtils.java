package com.google.android.gms.common.util;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
@KeepForSdk
/* loaded from: classes7.dex */
public final class CrashUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] zza;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1405622666, "Lcom/google/android/gms/common/util/CrashUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1405622666, "Lcom/google/android/gms/common/util/CrashUtils;");
                return;
            }
        }
        zza = new String[]{"android.", "com.android.", "dalvik.", "java.", "javax."};
    }

    public CrashUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @KeepForSdk
    public static boolean addDynamiteErrorToDropBox(@NonNull Context context, @NonNull Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, th)) == null) {
            try {
                Preconditions.checkNotNull(context);
                Preconditions.checkNotNull(th);
                return false;
            } catch (Exception e) {
                Log.e("CrashUtils", "Error adding exception to DropBox!", e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
