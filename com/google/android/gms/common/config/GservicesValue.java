package com.google.android.gms.common.config;

import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
@KeepForSdk
/* loaded from: classes7.dex */
public abstract class GservicesValue<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object zzc;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final String zza;
    @NonNull
    public final T zzb;
    @Nullable
    public T zzd;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1740763736, "Lcom/google/android/gms/common/config/GservicesValue;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1740763736, "Lcom/google/android/gms/common/config/GservicesValue;");
                return;
            }
        }
        zzc = new Object();
    }

    public GservicesValue(@NonNull String str, @NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zzd = null;
        this.zza = str;
        this.zzb = t;
    }

    @KeepForSdk
    public static boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (zzc) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Float> value(@NonNull String str, @NonNull Float f) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, f)) == null) ? new zzd(str, f) : (GservicesValue) invokeLL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Integer> value(@NonNull String str, @NonNull Integer num) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, num)) == null) ? new zzc(str, num) : (GservicesValue) invokeLL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Long> value(@NonNull String str, @NonNull Long l) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, l)) == null) ? new zzb(str, l) : (GservicesValue) invokeLL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<String> value(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) ? new zze(str, str2) : (GservicesValue) invokeLL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Boolean> value(@NonNull String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, str, z)) == null) ? new zza(str, Boolean.valueOf(z)) : (GservicesValue) invokeLZ.objValue;
    }

    @NonNull
    @KeepForSdk
    public final T get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            T t = this.zzd;
            if (t != null) {
                return t;
            }
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            synchronized (zzc) {
            }
            synchronized (zzc) {
            }
            try {
                return zza(this.zza);
            } catch (SecurityException unused) {
                long clearCallingIdentity = Binder.clearCallingIdentity();
                T zza = zza(this.zza);
                Binder.restoreCallingIdentity(clearCallingIdentity);
                return zza;
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return (T) invokeV.objValue;
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public final T getBinderSafe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() : (T) invokeV.objValue;
    }

    @VisibleForTesting
    @KeepForSdk
    public void override(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
            this.zzd = t;
            synchronized (zzc) {
                synchronized (zzc) {
                }
            }
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public void resetOverride() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.zzd = null;
        }
    }

    @NonNull
    public abstract T zza(@NonNull String str);
}
