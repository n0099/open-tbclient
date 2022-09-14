package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executor;
@KeepForSdk
/* loaded from: classes7.dex */
public abstract class GmsClientSupervisor {
    public static /* synthetic */ Interceptable $ic = null;
    @Nullable
    @VisibleForTesting
    public static HandlerThread zza = null;
    public static int zzb = 4225;
    public static final Object zzc;
    @Nullable
    public static zzr zzd;
    public static boolean zze;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(358918695, "Lcom/google/android/gms/common/internal/GmsClientSupervisor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(358918695, "Lcom/google/android/gms/common/internal/GmsClientSupervisor;");
                return;
            }
        }
        zzc = new Object();
    }

    public GmsClientSupervisor() {
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
    public static int getDefaultBindFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? zzb : invokeV.intValue;
    }

    @NonNull
    @KeepForSdk
    public static GmsClientSupervisor getInstance(@NonNull Context context) {
        InterceptResult invokeL;
        Looper mainLooper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (zzc) {
                if (zzd == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (zze) {
                        mainLooper = getOrStartHandlerThread().getLooper();
                    } else {
                        mainLooper = context.getMainLooper();
                    }
                    zzd = new zzr(applicationContext, mainLooper);
                }
            }
            return zzd;
        }
        return (GmsClientSupervisor) invokeL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static HandlerThread getOrStartHandlerThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (zzc) {
                HandlerThread handlerThread = zza;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                zza = handlerThread2;
                handlerThread2.start();
                return zza;
            }
        }
        return (HandlerThread) invokeV.objValue;
    }

    @KeepForSdk
    public static void setUseHandlerThreadForCallbacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            synchronized (zzc) {
                zzr zzrVar = zzd;
                if (zzrVar != null && !zze) {
                    zzrVar.zzi(getOrStartHandlerThread().getLooper());
                }
                zze = true;
            }
        }
    }

    @KeepForSdk
    public boolean bindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, componentName, serviceConnection, str)) == null) ? zzc(new zzn(componentName, getDefaultBindFlags()), serviceConnection, str, null) : invokeLLL.booleanValue;
    }

    @KeepForSdk
    public void unbindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, componentName, serviceConnection, str) == null) {
            zza(new zzn(componentName, getDefaultBindFlags()), serviceConnection, str);
        }
    }

    public abstract void zza(zzn zznVar, ServiceConnection serviceConnection, String str);

    public final void zzb(@NonNull String str, @NonNull String str2, int i, @NonNull ServiceConnection serviceConnection, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Integer.valueOf(i), serviceConnection, str3, Boolean.valueOf(z)}) == null) {
            zza(new zzn(str, str2, i, z), serviceConnection, str3);
        }
    }

    public abstract boolean zzc(zzn zznVar, ServiceConnection serviceConnection, String str, @Nullable Executor executor);

    @KeepForSdk
    public boolean bindService(@NonNull String str, @NonNull ServiceConnection serviceConnection, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, serviceConnection, str2)) == null) ? zzc(new zzn(str, getDefaultBindFlags(), false), serviceConnection, str2, null) : invokeLLL.booleanValue;
    }

    @KeepForSdk
    public void unbindService(@NonNull String str, @NonNull ServiceConnection serviceConnection, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, serviceConnection, str2) == null) {
            zza(new zzn(str, getDefaultBindFlags(), false), serviceConnection, str2);
        }
    }
}
