package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
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
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
/* loaded from: classes7.dex */
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public static /* synthetic */ Interceptable $ic;
    public static final BackgroundDetector zza;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean zzb;
    public final AtomicBoolean zzc;
    @GuardedBy("sInstance")
    public final ArrayList<BackgroundStateChangeListener> zzd;
    @GuardedBy("sInstance")
    public boolean zze;

    @KeepForSdk
    /* loaded from: classes7.dex */
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-408583920, "Lcom/google/android/gms/common/api/internal/BackgroundDetector;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-408583920, "Lcom/google/android/gms/common/api/internal/BackgroundDetector;");
                return;
            }
        }
        zza = new BackgroundDetector();
    }

    @KeepForSdk
    public BackgroundDetector() {
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
        this.zzb = new AtomicBoolean();
        this.zzc = new AtomicBoolean();
        this.zzd = new ArrayList<>();
        this.zze = false;
    }

    @NonNull
    @KeepForSdk
    public static BackgroundDetector getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? zza : (BackgroundDetector) invokeV.objValue;
    }

    @KeepForSdk
    public static void initialize(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, application) == null) {
            synchronized (zza) {
                BackgroundDetector backgroundDetector = zza;
                if (!backgroundDetector.zze) {
                    application.registerActivityLifecycleCallbacks(backgroundDetector);
                    application.registerComponentCallbacks(zza);
                    zza.zze = true;
                }
            }
        }
    }

    private final void zza(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            synchronized (zza) {
                Iterator<BackgroundStateChangeListener> it = this.zzd.iterator();
                while (it.hasNext()) {
                    it.next().onBackgroundStateChanged(z);
                }
            }
        }
    }

    @KeepForSdk
    public void addListener(@NonNull BackgroundStateChangeListener backgroundStateChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, backgroundStateChangeListener) == null) {
            synchronized (zza) {
                this.zzd.add(backgroundStateChangeListener);
            }
        }
    }

    @KeepForSdk
    public boolean isInBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.zzb.get() : invokeV.booleanValue;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, bundle) == null) {
            boolean compareAndSet = this.zzb.compareAndSet(true, false);
            this.zzc.set(true);
            if (compareAndSet) {
                zza(false);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            boolean compareAndSet = this.zzb.compareAndSet(true, false);
            this.zzc.set(true);
            if (compareAndSet) {
                zza(false);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) {
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && i == 20 && this.zzb.compareAndSet(false, true)) {
            this.zzc.set(true);
            zza(true);
        }
    }

    @KeepForSdk
    @TargetApi(16)
    public boolean readCurrentStateIfPossible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            if (!this.zzc.get()) {
                if (!PlatformVersion.isAtLeastJellyBean()) {
                    return z;
                }
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                if (!this.zzc.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                    this.zzb.set(true);
                }
            }
            return isInBackground();
        }
        return invokeZ.booleanValue;
    }
}
