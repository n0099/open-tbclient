package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
@KeepForSdk
/* loaded from: classes7.dex */
public class LifecycleCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    @KeepForSdk
    public final LifecycleFragment mLifecycleFragment;

    @KeepForSdk
    public LifecycleCallback(@NonNull LifecycleFragment lifecycleFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lifecycleFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLifecycleFragment = lifecycleFragment;
    }

    @Keep
    public static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity lifecycleActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, lifecycleActivity)) == null) {
            throw new IllegalStateException("Method not available in SDK.");
        }
        return (LifecycleFragment) invokeL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static LifecycleFragment getFragment(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) ? getFragment(new LifecycleActivity(activity)) : (LifecycleFragment) invokeL.objValue;
    }

    @KeepForSdk
    @MainThread
    public void dump(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, fileDescriptor, printWriter, strArr) == null) {
        }
    }

    @NonNull
    @KeepForSdk
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Activity lifecycleActivity = this.mLifecycleFragment.getLifecycleActivity();
            Preconditions.checkNotNull(lifecycleActivity);
            return lifecycleActivity;
        }
        return (Activity) invokeV.objValue;
    }

    @KeepForSdk
    @MainThread
    public void onActivityResult(int i, int i2, @NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
        }
    }

    @KeepForSdk
    @MainThread
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
        }
    }

    @KeepForSdk
    @MainThread
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @KeepForSdk
    @MainThread
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @KeepForSdk
    @MainThread
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
        }
    }

    @KeepForSdk
    @MainThread
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @KeepForSdk
    @MainThread
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @NonNull
    @KeepForSdk
    public static LifecycleFragment getFragment(@NonNull ContextWrapper contextWrapper) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, contextWrapper)) == null) {
            throw new UnsupportedOperationException();
        }
        return (LifecycleFragment) invokeL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static LifecycleFragment getFragment(@NonNull LifecycleActivity lifecycleActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, lifecycleActivity)) == null) {
            if (lifecycleActivity.zzd()) {
                return zzd.zzc(lifecycleActivity.zzb());
            }
            if (lifecycleActivity.zzc()) {
                return zzb.zzc(lifecycleActivity.zza());
            }
            throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
        }
        return (LifecycleFragment) invokeL.objValue;
    }
}
