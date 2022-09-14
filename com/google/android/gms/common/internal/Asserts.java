package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import javax.annotation.Nullable;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
@KeepForSdk
/* loaded from: classes7.dex */
public final class Asserts {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Asserts() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static void checkMainThread(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        String valueOf = String.valueOf(Thread.currentThread());
        String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
        sb.append("checkMainThread: current thread ");
        sb.append(valueOf);
        sb.append(" IS NOT the main thread ");
        sb.append(valueOf2);
        sb.append("!");
        Log.e("Asserts", sb.toString());
        throw new IllegalStateException(str);
    }

    @KeepForSdk
    public static void checkNotMainThread(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && Looper.getMainLooper().getThread() == Thread.currentThread()) {
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 56 + String.valueOf(valueOf2).length());
            sb.append("checkNotMainThread: current thread ");
            sb.append(valueOf);
            sb.append(" IS the main thread ");
            sb.append(valueOf2);
            sb.append("!");
            Log.e("Asserts", sb.toString());
            throw new IllegalStateException(str);
        }
    }

    @EnsuresNonNull({"#1"})
    @KeepForSdk
    public static void checkNotNull(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, obj) == null) && obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    @KeepForSdk
    public static void checkNull(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, obj) == null) && obj != null) {
            throw new IllegalArgumentException("non-null reference");
        }
    }

    @KeepForSdk
    public static void checkState(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65542, null, z) == null) && !z) {
            throw new IllegalStateException();
        }
    }

    @EnsuresNonNull({"#1"})
    @KeepForSdk
    public static void checkNotNull(@Nullable Object obj, @NonNull Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, obj2) == null) && obj == null) {
            throw new IllegalArgumentException(String.valueOf(obj2));
        }
    }

    @KeepForSdk
    public static void checkState(boolean z, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65543, null, z, obj) == null) && !z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
