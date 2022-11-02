package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
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
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
@KeepForSdk
/* loaded from: classes7.dex */
public class ConnectionTracker {
    public static /* synthetic */ Interceptable $ic;
    public static final Object zzb;
    @Nullable
    public static volatile ConnectionTracker zzc;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    @VisibleForTesting
    public ConcurrentHashMap<ServiceConnection, ServiceConnection> zza;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1086438039, "Lcom/google/android/gms/common/stats/ConnectionTracker;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1086438039, "Lcom/google/android/gms/common/stats/ConnectionTracker;");
                return;
            }
        }
        zzb = new Object();
    }

    public ConnectionTracker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zza = new ConcurrentHashMap<>();
    }

    @NonNull
    @KeepForSdk
    public static ConnectionTracker getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (zzc == null) {
                synchronized (zzb) {
                    if (zzc == null) {
                        zzc = new ConnectionTracker();
                    }
                }
            }
            ConnectionTracker connectionTracker = zzc;
            Preconditions.checkNotNull(connectionTracker);
            return connectionTracker;
        }
        return (ConnectionTracker) invokeV.objValue;
    }

    public static void zzb(Context context, ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, serviceConnection) == null) {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
            }
        }
    }

    @KeepForSdk
    public void unbindServiceSafe(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, serviceConnection) == null) {
            try {
                unbindService(context, serviceConnection);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    private final boolean zzc(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z, @Nullable Executor executor) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{context, str, intent, serviceConnection, Integer.valueOf(i), Boolean.valueOf(z), executor})) == null) {
            ComponentName component = intent.getComponent();
            if (component != null) {
                String packageName = component.getPackageName();
                "com.google.android.gms".equals(packageName);
                try {
                    if ((Wrappers.packageManager(context).getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                        return false;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            if (zzd(serviceConnection)) {
                ServiceConnection putIfAbsent = this.zza.putIfAbsent(serviceConnection, serviceConnection);
                if (putIfAbsent != null && serviceConnection != putIfAbsent) {
                    Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
                }
                try {
                    boolean zze = zze(context, intent, serviceConnection, i, executor);
                    if (!zze) {
                        return false;
                    }
                    return zze;
                } finally {
                    this.zza.remove(serviceConnection, serviceConnection);
                }
            }
            return zze(context, intent, serviceConnection, i, executor);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean zzd(ServiceConnection serviceConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, serviceConnection)) == null) {
            if (!(serviceConnection instanceof zzs)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean zze(Context context, Intent intent, ServiceConnection serviceConnection, int i, @Nullable Executor executor) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, intent, serviceConnection, Integer.valueOf(i), executor})) == null) {
            if (PlatformVersion.isAtLeastQ() && executor != null) {
                return context.bindService(intent, i, executor, serviceConnection);
            }
            return context.bindService(intent, serviceConnection, i);
        }
        return invokeCommon.booleanValue;
    }

    @KeepForSdk
    public boolean bindService(@NonNull Context context, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, context, intent, serviceConnection, i)) == null) {
            return zzc(context, context.getClass().getName(), intent, serviceConnection, i, true, null);
        }
        return invokeLLLI.booleanValue;
    }

    @KeepForSdk
    public void unbindService(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, serviceConnection) == null) {
            if (zzd(serviceConnection) && this.zza.containsKey(serviceConnection)) {
                try {
                    zzb(context, this.zza.get(serviceConnection));
                    return;
                } finally {
                    this.zza.remove(serviceConnection);
                }
            }
            zzb(context, serviceConnection);
        }
    }

    public final boolean zza(@NonNull Context context, @NonNull String str, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i, @Nullable Executor executor) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, str, intent, serviceConnection, Integer.valueOf(i), executor})) == null) {
            return zzc(context, str, intent, serviceConnection, i, true, executor);
        }
        return invokeCommon.booleanValue;
    }
}
